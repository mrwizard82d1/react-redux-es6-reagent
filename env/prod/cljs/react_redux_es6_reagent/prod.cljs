(ns react-redux-es6-reagent.prod
  (:require [react-redux-es6-reagent.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
