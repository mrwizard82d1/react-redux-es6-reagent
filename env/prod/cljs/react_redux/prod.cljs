(ns react-redux.prod
  (:require [react-redux.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
