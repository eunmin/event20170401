(ns event20170401.events
    (:require [re-frame.core :as re-frame]
              [event20170401.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
