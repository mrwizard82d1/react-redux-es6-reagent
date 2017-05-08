(ns react-redux.components
  (:require [reagent.session :as session]))

;; -------------------------
;; Views

(defn home []
  [:div {:class "jumbotron"} [:h1 "Welcome to Reagent"]
   [:p "React in ClojureScript for ultra-responsive web apps."]
   [:a {:href "/about" :class "btn btn-primary btn-lg"} "Learn More"]])

(defn about []
  [:div [:h1 "About"]
   [:p "This application uses ClojureScript, Secretary and other helpful libraries."]])

(defn active-page-styling [for-page]
  (if (= (session/get :current-page) for-page)
    {:class "active"}))

(defn header []
  [:div
   [:a (merge {:href "/"} (active-page-styling #'home)) "Home"]
   " | "
   [:a (merge {:href "/about"} (active-page-styling #'about)) "About"]])

;; Current page
(defn current-page []
  [:div {:class "container-fluid"}
   [header]
   [(session/get :current-page)]])

(def component {:home #'home
                :about #'about})
