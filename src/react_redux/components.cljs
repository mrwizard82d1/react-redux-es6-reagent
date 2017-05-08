(ns react-redux.components
  (:require [reagent.session :as session]))

;; -------------------------
;; Views

(defn home-page []
  [:div {:class "jumbotron"} [:h1 "Welcome to Reagent"]
   [:p "React in ClojureScript for ultra-responsive web apps."]
   [:a {:href "/about" :class "btn btn-primary btn-lg"} "Learn More"]])

(defn about-page []
  [:div [:h1 "About"]
   [:p "This application uses ClojureScript, Secretary and other helpful libraries."]])

(defn active-page-styling [for-page]
  (if (= (session/get :current-page) for-page)
    {:class "active"}))

(defn header []
  [:div
   ; I don't like this! I must know that `core` sets the current page to `(var home-page)`
   ; I need to think about how to fix this.
   [:a (merge {:href "/"} (active-page-styling #'home-page)) "Home"]
   " | "
   [:a (merge {:href "/about"} (active-page-styling #'about-page)) "About"]])

(defn app []
  [:div {:class "container-fluid"}
   (header)
   (home-page)
   (about-page)])
