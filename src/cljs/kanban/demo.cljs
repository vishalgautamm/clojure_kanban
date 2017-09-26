; (ns kanban.core
;   (:require [reagent.core :as reagent :refer [atom]]))
;
; (enable-console-print!)
;
; (defonce app-header (atom {:text "Click Mania Game!"}))
; (defonce click-count (atom 0))
;
; (defn header []
;   [:div.childcomponent
;     [:h1 (:text @app-header)]
;   ]
; )
;
; (defn state-ful-with-atom []
;     [:div
;       [:p  "I have been clicked " @click-count " times."]
;     ]
; )
;
; (defn button []
;     [:div.buttons
;       [:button.btn.btninc {:on-click #(swap! click-count inc)} "increment"]
;       [:button.btn.btndec {:on-click #(swap! click-count dec)} "decrement"]
;       [:button.btn.btnreset {:on-click #(reset! click-count 0)} "reset"]
;     ]
; )
;
; (defn greeting []
;   [:div.parentcomponent
;     [header]
;     [state-ful-with-atom]
;     [button]
; ])
;
; (defn render []
;   (reagent/render [greeting] (js/document.getElementById "app")))
