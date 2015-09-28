(ns sonar.extractvalues)
(require '[net.cgrand.enlive-html :as html])

(def technical_debt {"m_sqale_index" :id})
(def blockers {"m_blocker_violations" :id})
(def critial_violations {"m_critical_violations" :id})
(def major_violations {"m_major_violations" :id})
(def minor_violations {"m_minor_violations" :id})
(def info_violations {"m_info_violations" :id})
(def undocumented_api {"m_public_undocumented_api" :id})
(hash-map technical_debt blockers )
(def map_attributes (apply merge
                           technical_debt
                           blockers
                           critial_violations
                           major_violations
                           minor_violations
                           info_violations
                           undocumented_api))



(def url (html/html-snippet (slurp "/home/bodhi/Downloads/sonar.html")))
(html/select-nodes* url [(html/attr= :id "m_blocker_violations") html/any-node])

(defn getAttrValue
  "Retrieves the Attribute value of a specific element name"
  [element name]
  (html/select-nodes* url [(html/attr= element name) html/any-node]))

(defn getAttrValueMap
  "Retrieves the Attribute value of a specific element name"
  [entry]
  (let [{name :key id :id} entry]
    (prn name id)
    (html/select-nodes* url [(html/attr= id name) html/any-node])))

(defn getSpan [number]
  (nth (html/select url #{[:span]}) number))

(defn getAttrs [number]
  (get (getSpan number) :attrs))
(defn getAttrsFromItem [item]
  (get item :attrs))
(defn getId [number]
  (get (getAttrs number) :id))

(getAttrValue :id "m_sqale_index")
(getAttrValue :class "varw widget-link widget-link-red link-rules-new-debt")
(getAttrValue :class "varw")


(defn getSpan [number]
  (nth (html/select url #{[:span]}) number))
(html/id= "m_sqale_index")


(html/select-nodes* url html/any-node)
(defn getAttrValue [element]
  (html/select-nodes* url [(html/attr= element) html/any-node]))

(getAttrValue "m_public_undocumented_api")
