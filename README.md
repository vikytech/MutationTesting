[![Watch the video](https://user-images.githubusercontent.com/3875111/116968161-900f5b80-acd1-11eb-93b0-ef9d12aa4826.png)](https://www.youtube.com/watch?v=nTTp8c1C8jA)

# What is Mutation testing

Mutation testing (or mutation analysis or program mutation) is used to design new software tests and evaluate the quality of existing software tests.
Each mutated version is called a mutant and tests detect and reject mutants by causing the behavior of the original version to differ from the mutant.

## Things to consider

*   Limit the mutation operators used
*   Limit the number of mutations per class
*   Tweak the number of threads
*   Target only specific portions of your codebase
*   Don't run this with every commit as it takes time to run these test....may be as smoke test

## Setup

* [Gradle](#gradle)
* [Intellij Plugin](#intellij-plugin)
* [CLI](#command-line)

### Gradle

Add Pitest plugin to gradle
```
id 'info.solidsoft.pitest' version '1.5.2'
```

Create pitest task with your needed configuration
```
pitest {
    mainSourceSets.set([sourceSets.main]) // Only for individual contribution, not recommended for repo having more than 10-15 classes
    testSourceSets.set([sourceSets.test]) // Only for individual contribution, not recommended for repo having more than 10-15 classes
    targetClasses.set(["com.foo.*","com.bar.*"]) // Ignore if mainSourceSets & testSourceSets is specified
    excludedClasses.set(["com.foo1.*","com.bar.IT*"])  // Ignore if mainSourceSets & testSourceSets is specified
    pitestVersion.set('1.6.7') // Not needed if you want to use the default version provided by plugin
    junit5PluginVersion.set('0.14')
    outputFormats.set(['HTML']) // XML is also available
    mutators.set(["ROR", "RETURN_VALS", "INVERT_NEGS", "MATH", "VOID_METHOD_CALLS", "NON_VOID_METHOD_CALLS"])
    avoidCallsTo.set(["java.util", "java.lang"])
    threads.set(4)
    timestampedReports.set(false)
    mutationThreshold.set(95)
    coverageThreshold.set(95)
}
```

Bind the created task with `test`/`build` task as required
```
test {
    finalizedBy 'pitest'
}
```

### Intellij Plugin

Intellij idea → Preferences → Plugins → search "[PIT mutation testing Idea plugin](https://plugins.jetbrains.com/plugin/7119-pit-mutation-testing-idea-plugin/)"

#### Extra Params passed to plugin:

Edit configuration for Pitest Runner and add the needed parameters from below

#### Target Classes:
```
    Flag: --targetClasses
    Possible Values: PackagePath

    Eg: `--targetClasses com.foo.service.auth*,com.foo.service.product.service.*`
```

#### Source Directory:
```
    Flag: --sourceDirs
    Possible Value: Package ROOT Path

    Eg: `--sourceDirs <PATH_TO_BASE_DIR>/service/src/main`
```

#### Output Formats:
```
List of formats in which to write mutation results as the mutations are analysed. Supported formats are HTML, XML, CSV.

    Flag: --outputFormats
    Possible Values: XML,HTML

    Eg: `--outputFormats XML,HTML`
```

#### Exclude Unit Tests:
```
    Flag: --excludedClasses
    Possible Values: REGEX/FileName
Eg: `--excludedClasses *Test`
```

#### Exclude Integration Tests:
```
    Flag: --excludedTestClasses
    Possible Values: REGEX/FileName

    Eg: `--excludedTestClasses *IntegrationTests,*IntegrationTest`

    PIT filters are matched against the class names in the compiled binary, not against the source file name.
```

#### Exclude annotators:
```
Flag: --excludedMethods
Possible Values: annotator names

Eg: `--excludedMethods toString,hashCode,equals`

    Excluded methods are used to avoid creating mutants within methods that match the supplied list of names.

PIT test will not consider spring annotator like @Service, @Api, @RestController whereas it mutates other value based spring annotations like @Value and also java annotations like @ToString,@EqualsAndHashCode
```

#### Customize mutator(s):
```
Flag: --mutators
Possible Values: Mutator type

Eg: `--mutators ROR,RETURN_VALS`

List of Mutators recommended
    ROR
    RETURN_VALS
    INVERT_NEGS
    MATH
    VOID_METHOD_CALLS
    NON_VOID_METHOD_CALLS
```
If we need to use other mutators, vist [official page](https://pitest.org/quickstart/mutators)

#### Verbose:
```
Flag: --verbose
```

## Command Line

export a variable named `$CLASSPATH` and add all the paths to the dependency jars and [Pitest jars](https://github.com/hcoles/pitest/releases)

    Pitest jars
    * pitest-x.y.z.jar
    * pitest-command-line-x.y.z.jar
    * pitest-entry-x.y.z.jar

Command:
```
java -cp $CLASSPATH \

org.pitest.mutationtest.commandline.MutationCoverageReport \

--reportDir <PROJECT_PATH>/build/reports/pittest \

--sourceDirs <PROJECT_PATH>/<MAIN_SRC_PATH> \

--outputFormats XML,HTML \

--mutators ROR,RETURN_VALS,INVERT_NEGS,MATH,VOID_METHOD_CALLS \

--targetClasses "com.foo.service.auth*,com.foo.service.product.*" \

--excludedClasses "*Test" \

--excludedTestClasses "*IntegrationTests,*IntegrationTest"
```



#### NOTE: All the above documentation tested on Pitest-1.5.2
