(ns react-redux.core
    (:require [reagent.core :as reagent]))

;; -------------------------
;; Views

(defn home-page []
  [:div {:class "jumbotron"} [:h1 "Welcome to Reagent"]
   [:p "React in ClojureScript for ultra-responsive web apps."]
   [:a {:href "/about" :class "btn btn-primary btn-lg"} "Learn More"]])

(defn about-page []
  [:div [:h1 "About"]
   [:p "This application uses ClojureScript, Secretary and other helpful libraries."]])

(defn app []
  [:div {:class "container-fluid"}
   [:p "Header here..."]
   (home-page)
   (about-page)])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [app] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
