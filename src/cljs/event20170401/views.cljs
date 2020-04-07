(ns event20170401.views
    (:require [re-frame.core :as re-frame]
              [reagent.core :as r]
              [clojure.string :refer [split-lines]]))

(defn header-panel []
  (let [groom (re-frame/subscribe [:groom])
        bride (re-frame/subscribe [:bride])
        cover (re-frame/subscribe [:cover])
        event-when (re-frame/subscribe [:when])
        window (re-frame/subscribe [:window])]
    (fn []
      [:div.wrap_cover {:style {:width (:width @window)}}
        [:div.cover_item {:style {:height (:height @window)}}
          [:div#header.cover_image {:style {:background-image (str "url(images/" @cover ")")}}
            [:div.cover_cell
              [:div#title
                [:span (:name @groom)]
                [:span " · "]
                [:span (:name @bride)]]
              [:div#subtitle
                [:span @event-when]]]]]])))

(defn invitation-panel []
  (let [groom (re-frame/subscribe [:groom])
        bride (re-frame/subscribe [:bride])
        invitation (re-frame/subscribe [:invitation])]
    (fn []
      [:div#invitation
        [:div
          (for [text (split-lines @invitation)]
            ^{:key text} [:div
                          [:span.article text]])]
        [:div#family
          [:div
            [:span.article_m (str (:father @groom) " · " (:mother @groom))]
            [:span.small "의 아들"]
            [:span.article_m (:name @groom)]]
          [:div
            [:span.article_m (str (:father @bride) " · " (:mother @bride))]
            [:span.small "의 딸"]
            [:span.article_m (:name @bride)]]]])))

(defn info-panel []
  (let [event-when (re-frame/subscribe [:when])
        location (re-frame/subscribe [:location])]
    (fn []
      [:div#info
        [:div#when [:span.article.calandar @event-when]]
        [:div#location [:span.article @location]]
        [:div [:img.map {:src "images/map.png"}]]])))

(defn grallery-panel []
  (let [photos (re-frame/subscribe [:photos])]
    (fn []
      [:div#grallery-panel
        (for [url @photos]
          ^{:key url} [:div.grallery [:img.photo {:src (str "images/" url)}]])])))

(defn footer-panel []
  (r/create-class
    {:component-did-mount
     (fn []
       (.log js/console "AA")
       (js/Kakao.init "743de0eee134fea91ddd7a9274aab6e0")
       (js/Kakao.Link.createTalkLinkButton
         #js {:container "#kakao-link-btn"
              :label "test"
              :image {:src "https://20170401.github.io/images/KDI_8425.jpg"}
              :webButton {:text "gg" :url "https://20170401.github.io"}}))
     :reagent-render
     (fn []
      [:div#footer
        [:div
          [:a#kakao-link-btn {:href "javascript;"} "test"]]
        [:div.re_frame]])}))

(defn main-panel []
  (let [window (re-frame/subscribe [:window])]
    (fn []
      [:div#main
        [header-panel]
        [:div.wrap_body {:style {:margin-top (:height @window)}}
          [invitation-panel]
          [:hr]
          [info-panel]
          [:hr]
          [grallery-panel]
          [footer-panel]]])));
