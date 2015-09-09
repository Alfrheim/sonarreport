(ns sonar.core
  (:gen-class))
(require '[net.cgrand.enlive-html :as html])

(defn fetch-url
  "Retrieves the web page specified by the url and
   makes an html-resource out of it which is used
   by enlive."
  [url] (html/html-resource (java.net.URL. url)))

(def url (html/html-snippet (slurp "/home/bodhi/Downloads/sonar.html")))
;;(def url (fetch-url "http:///sonar/dashboard/index/21712?did=1"))
(html/select (html/html-snippet file) #{[:span]})
(html/select url #{[:span]})
(vals (first url))
;(keys ({:tag :span, :attrs nil, :content ("Projects")}))
(html/select url #{[:class]})
(html/id= "m_sqale_index")
(def id 83)

(defn getSpan [number]
  (nth (html/select url #{[:span]}) number))

(defn getAttrs [number]
  (get (getSpan number) :attrs))

(defn getId [number]
  (get (getAttrs number) :id))

(getSpan id)
(getAttrs id)
(getId id)
(get (getSpan id) :content)
(= "m_sqale_index" (getId id))
;(defn selector [id elements]
;  (doseq ))
(html/select-nodes* url [(html/attr= :id "m_public_undocumented_api") html/any-node])
; un altre intent
(getAttrValue :id "m_public_undocumented_api")
(getAttrValue :class "varw widget-link widget-link-red link-rules-new-debt")
(getAttrValue :class "var")
(defn getAttrValue [element name]
  (html/select-nodes* url [(html/attr= element name) html/any-node]))

(defn getAttrs [number]
  (get (getSpan number) :attrs))
(defn getAttrsFromItem [item]
  (get item :attrs))
(defn getId [number]
  (get (getAttrs number) :id))

(getSpan id)
(getAttrs id)
(getId id)
((getSpan id) :content)
(= "m_sqale_index" (getId id))
(doseq [item (nth (html/select url #{[:span]}) 83)]
  (if (= "m_sqale_index" ((getAttrsFromItem (nth (html/select url #{[:span]}) 83)) :id))
    "wooo"
    "buuu"))

(if (= "m_sqale_index" ((getAttrsFromItem (nth (html/select url #{[:span]}) 83)) :id))
  "wooo"
  "buuu")
; fins aqui l'intent


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
