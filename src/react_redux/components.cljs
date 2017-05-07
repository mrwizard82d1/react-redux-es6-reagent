(ns react-redux.components)

;; -------------------------
;; Views

(defn home-page []
  [:div {:class "jumbotron"} [:h1 "Welcome to Reagent"]
   [:p "React in ClojureScript for ultra-responsive web apps."]
   [:a {:href "/about" :class "btn btn-primary btn-lg"} "Learn More"]])

(defn about-page []
  [:div [:h1 "About"]
   [:p "This application uses ClojureScript, Secretary and other helpful libraries."]])

(defn header []
  [:div
   [:a {:href "/"} "Home"]
   [:a {:href "/about"} "About"]])

(defn app []
  [:div {:class "container-fluid"}
   (header)
   (home-page)
   (about-page)])
