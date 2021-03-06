(ns leiningen.utils-test
  (:require [clojure.test :refer :all]
            [leiningen.remote.utils.utils :as u]))

(deftest ^:unit test-parse-init
  (is (= 20 (u/parse-port "20")))
  (is (= 0 (u/parse-port "0")))
  (is (= :invalid (u/parse-port "sds")))
  (is (= :empty (u/parse-port ""))))

(deftest ^:unit test-exists?
  (is (true? (u/exists? "test-resources/test.patch")))
  (is (false? (u/exists? "test-resources/unknow n.patch"))))

(deftest ^:unit test-yes-or-no
  (is (true? (u/yes-or-no "y")))
  (is (true? (u/yes-or-no "n")))
  (is (false? (u/yes-or-no "")))
  (is (false? (u/yes-or-no nil)))
  (is (false? (u/yes-or-no "ja"))))
