(ns react-redux.core
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [react-redux.components :as components]))

;; Current page
(defn current-page []
  [:div {:class "container-fluid"}
   [components/header]
   [(session/get :current-page)]])

;; Routes
(secretary/defroute "/" []
  (session/put! :current-page #'components/home-page))

(secretary/defroute "/about" []
  (session/put! :current-page #'components/about-page))

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation! {:nav-handler (fn [path]
                                                    (secretary/dispatch! path))
                                     :path-exists? (fn [path]
                                                     (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
