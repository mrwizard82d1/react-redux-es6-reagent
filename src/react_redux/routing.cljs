(ns react-redux.routing
  (:require [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [react-redux.components :as components]))

;; Routes
(defn app-routes []
  (secretary/defroute "/" []
    (session/put! :current-page (components/component :home)))

  (secretary/defroute "/courses" []
    (session/put! :current-page (components/component :courses)))

  (secretary/defroute "/about" []
    (session/put! :current-page (components/component :about)))

  (secretary/defroute "*" []
    (session/put! :current-page (components/component :home))))

