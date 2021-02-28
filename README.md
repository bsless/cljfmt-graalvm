# cljfmt-graalvm

[cljfmt](https://github.com/weavejester/cljfmt)
is a tool for formatting Clojure code idiomatically.

Update: cljfmt now has support for native image building.

The need arose to run cljfmt quickly without a JVM. That is all this
repo provides. Any piece of code in it is copied from
`weavejester/cljfmt` or from `clojure.stacktrace`. The code was only
copied to type hint class types the native image could not figure out.

The compile script is based on
[clj-kondo's](https://github.com/borkdude/clj-kondo/blob/master/script/compile)

All credit goes to Weavejester (James Reeves, cljfmt) and Borkdude
(Michiel Borkent, clj-kondo) Stuart Sierra (stacktrace) and their
respective contributors.

## Prerequisites

- Get [GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases)
- Set `GRAALVM_HOME` to the unpacked archive or add `$GRAALVM_HOME/bin` to your path
- Clone this repo

## Installation

run `script/compile`

## Usage

Just like `cljfmt`, just use the binary instead of a lein task.

## Options

Just like `cljfmt`

## License

Copyright © 2020 Ben Sless

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
