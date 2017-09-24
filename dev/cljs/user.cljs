(ns cljs.user
  (:require [kanban.core]
            [kanban.system :as system]))

(def go system/go)
(def reset system/reset)
(def stop system/stop)
(def start system/start)
