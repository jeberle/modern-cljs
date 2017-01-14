(set-env!
  :source-paths   #{"src/cljs"}
  :resource-paths #{"html"}
  :dependencies
  '[[org.clojure/clojure       "1.7.0"     :scope "provided"]
    [org.clojure/clojurescript "1.7.170"   :scope "provided"]
    [adzerk/boot-cljs          "1.7.170-3" :scope "test"]
    [pandeiro/boot-http        "0.7.0"     :scope "test"]
    [adzerk/boot-reload        "0.4.9"     :scope "test"]
    [adzerk/boot-cljs-repl     "0.3.0"     :scope "test"]
    [com.cemerick/piggieback   "0.2.1"     :scope "test"]
    [weasel                    "0.7.0"     :scope "test"]
    [org.clojure/tools.nrepl   "0.2.12"    :scope "test"]])

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[pandeiro.boot-http :refer [serve]]
  '[adzerk.boot-reload :refer [reload]]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])

(deftask dev
  "Launch Immediate Feedback Development Environment"
  []
  (comp
    (serve :dir "target")
    (watch)
    (reload)
    (cljs-repl)
    (cljs)
    (target :dir #{"target"})))

; vim: ft=clojure
