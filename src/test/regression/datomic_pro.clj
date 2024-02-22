(ns test.regression.datomic-pro
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/test-db")

(defn create-db []
  (d/create-database db-uri))

(defn conn []
  (d/connect db-uri))

(def schema [{:db/ident :foo/bars
              :db/valueType :db.type/ref
              :db/cardinality :db.cardinality/many}
             {:db/ident :foo/id
              :db/valueType :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/identity}
             {:db/ident :bar/id
              :db/valueType :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/identity}])

(defn transact-schema [conn]
  (d/transact conn schema))

(defn transact-entities [conn]
  (d/transact conn [{:db/id "bar1"
                     :bar/id #uuid "113F985E-81B9-46DD-80BE-E1D79C283029"}
                    {:db/id "bar2"
                     :bar/id #uuid "205CD73B-8158-44F7-9628-17125F8AA36B"}
                    {:db/id "foo1"
                     :foo/id #uuid "E9CC1EB6-31D7-4712-8948-F84134C8B8BC"}
                    {:db/id "foo2"
                     :foo/id #uuid "11CC2469-4EFD-48A5-A40D-91D8886A2E9E"
                     :foo/bars ["bar1" "bar2"]}]))
(defn count-foos [conn]
  (let [result (d/q '[:find (pull ?x [*])
                      :where [?x :foo/id]] (d/db conn))]
    (count result)))

(comment

  (create-db "test-db")
  (def conn (conn))
  (transact-schema conn)
  (transact-entities conn)



  (count-foos conn)
  )
