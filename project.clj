(defproject dataviz "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[cheshire "5.8.1"]
                 [clojure.java-time "0.3.2"]
                 [compojure "1.6.1"]
                 [conman "0.8.3"]
                 [cprop "0.1.13"]
                 [funcool/struct "1.3.0"]
                 [luminus-immutant "0.2.4"]
                 [luminus-migrations "0.6.3"]
                 [luminus-transit "0.1.1"]
                 [luminus/ring-ttl-session "0.3.2"]
                 [markdown-clj "1.0.5"]
                 [metosin/muuntaja "0.6.3"]
                 [metosin/ring-http-response "0.9.1"]
                 [mount "0.1.15"]
                 [nrepl "0.5.3"]
                 [me.raynes/fs "1.4.6"]
                 [funcool/cuerdas "2.0.6"]
                 [etaoin "0.2.9"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [org.clojure/clojure "1.10.0"]
                 [org.clojure/core.cache "0.7.1"]
                 [org.clojure/tools.cli "0.4.1"]
                 [org.clojure/tools.logging "0.4.1"]
                 [org.webjars.bower/tether "1.4.4"]
                 [org.webjars/bootstrap "4.1.3"]
                 [org.webjars/font-awesome "5.6.1"]
                 [org.webjars/jquery "3.3.1-1"]
                 [org.webjars/webjars-locator "0.34"]
                 [org.xerial/sqlite-jdbc "3.25.2"]
                 [ring-webjars "0.2.0"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-defaults "0.3.2"]
                 [selmer "1.12.5"]
                 [com.openhtmltopdf/openhtmltopdf-core "0.0.1-RC17"]
                 [com.openhtmltopdf/openhtmltopdf-pdfbox "0.0.1-RC17"]
                 [com.openhtmltopdf/openhtmltopdf-rtl-support "0.0.1-RC17"]
                 [com.openhtmltopdf/openhtmltopdf-svg-support "0.0.1-RC17"]
                 [org.jsoup/jsoup "1.11.3"]
                 [commons-io/commons-io "2.6"]]

  :min-lein-version "2.0.0"
  
  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :resource-paths ["resources"]
  :target-path "target/%s/"
  :main ^:skip-aot dataviz.core

  :plugins [[lein-immutant "2.1.0"]]

  :profiles
  {:uberjar {:omit-source true
             :aot :all
             :uberjar-name "dataviz.jar"
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}

   :dev           [:project/dev :profiles/dev]
   :test          [:project/dev :project/test :profiles/test]

   :project/dev  {:jvm-opts ["-Dconf=dev-config.edn"]
                  :dependencies [[expound "0.7.2"]
                                 [pjstadig/humane-test-output "0.9.0"]
                                 [prone "1.6.1"]
                                 [ring/ring-devel "1.7.1"]
                                 [ring/ring-mock "0.3.2"]]
                  :plugins      [[com.jakemccrary/lein-test-refresh "0.23.0"]]
                  
                  :source-paths ["env/dev/clj"]
                  :resource-paths ["env/dev/resources"]
                  :repl-options {:init-ns user}
                  :injections [(require 'pjstadig.humane-test-output)
                               (pjstadig.humane-test-output/activate!)]}
   :project/test {:jvm-opts ["-Dconf=test-config.edn"]
                  :resource-paths ["env/test/resources"]}
   :profiles/dev {}
   :profiles/test {}})