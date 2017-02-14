(ns event20170401.db)

(def default-db
  {:window {:height (.-innerHeight js/window)
            :width (.-innerWidth js/window)}
   :groom {:name "김은민" :father "김진충" :mother "차금애"}
   :bride {:name "정은하" :father "정진옥" :mother "조진숙"}
   :cover "KDI_7906.jpg"
   :when "2017년 4월 1일 (토) 오후 3시 30분"
   :location "잠실 아펠가모 / 한국광고문화회관 2층"
   :invitation "각자의 배낭을 메고 여행하던 두 사람이
                이제 나란한 발걸음을 옮겨 보려고 합니다.
                길가의 작은 꽃, 맑은 날의 햇살같은 일상의 행복을
                소중히 여기는 부부가 되겠습니다.
                함께 걷는 길의 시작,
                따듯한 마음으로 축복해 주시면
                큰 기쁨으로 간직하겠습니다."
   :photos ["KDI_8211.jpg"
            "KDI_7925.jpg"
            "KDI_8039.jpg"
            "KDI_8362.jpg"
            "KDI_8305.jpg"
            "KDI_8425.jpg"
            "KDI_8531.jpg"]})
