(ns react-redux.core
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [react-redux.components :as components]
              [react-redux.routing :as routing]))

(enable-console-print!)

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [components/current-page] (.getElementById js/document "app")))

(defn init! []
  (routing/app-routes)
  (accountant/configure-navigation! {:nav-handler (fn [path]
                                                    (secretary/dispatch! path))
                                     :path-exists? (fn [path]
                                                     (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
