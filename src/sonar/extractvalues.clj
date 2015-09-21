(ns sonar.extractvalues)
(require '[net.cgrand.enlive-html :as html])


(def map_attributes (hash-map
                     "m_blocker_violations" :id,
                     "m_public_undocumented_api" :id))

(def url (html/html-snippet (slurp "/home/bodhi/Downloads/sonar.html")))
(html/select-nodes* url [(html/attr= :id "m_public_undocumented_api") html/any-node])
(defn getAttrValue
  "Retrieves the Attribute value of a specific element name"
  [key name]
  (html/select-nodes* url [(html/attr= key name) html/any-node]))


(defn getSpan [number]
  (nth (html/select url #{[:span]}) number))

(defn getAttrs [number]
  (get (getSpan number) :attrs))
(defn getAttrsFromItem [item]
  (get item :attrs))
(defn getId [number]
  (get (getAttrs number) :id))

(getAttrValue :id "m_public_undocumented_api")
(getAttrValue :class "varw widget-link widget-link-red link-rules-new-debt")
(getAttrValue :class "var")
