(ns event20170401.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :window
 (fn [db]
   (:window db)))

(re-frame/reg-sub
 :cover
 (fn [db]
   (:cover db)))

(re-frame/reg-sub
 :groom
 (fn [db]
   (:groom db)))

(re-frame/reg-sub
 :bride
 (fn [db]
   (:bride db)))

(re-frame/reg-sub
 :when
 (fn [db]
   (:when db)))

(re-frame/reg-sub
 :invitation
 (fn [db]
   (:invitation db)))

(re-frame/reg-sub
 :location
 (fn [db]
   (:location db)))

(re-frame/reg-sub
 :photos
 (fn [db]
   (:photos db)))
