(defproject cljfmt-graalvm (slurp "./resources/cljfmt_graal_version")
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.2"]
                 [cljfmt "0.7.0"]]
  :global-vars {#_#_*assert* false
                #_#_*warn-on-reflection* true}
  :main cljfmt-graalvm.core
  :target-path "target/%s"
  :jvm-opts ["-Dclojure.compiler.direct-linking=true"
             "-Dclojure.spec.skip-macros=true"]
  :profiles {:uberjar {:aot :all}})
