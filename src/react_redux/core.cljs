(ns react-redux.core
    (:require [reagent.core :as reagent]
              [react-redux.components :as components]))

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [components/app] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
