(ns kanban.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(def app-state
  (r/atom
   {:columns [{:title "Todos"
               :cards [{:title "Learn about Reagent"}
                       {:title "Learn React"}]}
              {:title "Functional Programming"
               :editing true
               :cards [{:title "Elm is awesome"}
                       {:title "Decoding sucks though"
                        :editing true}]}
              {:title "Clojure Programming Lang"
               :cards [{:title "Clojure is amazing" :editing true}
                       {:title "Formatting is a bitch though"
                        :editing true}]}]}))

(defn Header []
  [:div.header
   [:h2 "Crello"]])

(defn Card [card]
  (if (:editing card)
    [:div.card.editing [:input {:type "text" :value (:title card)}]]
    [:div.card (:title card)]))

(defn NewCard []
  [:div.new-card
   "+ a new card"])

(defn Column [{:keys [title cards editing]}]
  [:div.column
   (if editing
     [:input {:type "text" :value title}]
     [:h3  title])
   (for [c cards]
     [Card c])
   [NewCard]])

(defn NewColumn []
  [:div.new-column
   "+ a new column"])

(defn Board [state]
  [:div.wrapper
   [Header]
   [:div.board
    (for [c (:columns @state)]
      [Column c])
    [NewColumn]]])

(defn render []
  (r/render [Board app-state] (js/document.getElementById "app")))
