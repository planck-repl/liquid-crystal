(ns liquid-xtal.core
  (:require [shared-structs]))

(def structs
  (js/sharedStructs "
  struct aStruct {
      int32_t i;
      char buf[1024];
      char someChar;
      int someInt;
  }
  "))

(let [struct (.aStruct structs)]
  (set! (.-i struct) 42)
  (aset (.-buf struct) 0 (.charCodeAt \A 0))
  (aset (.-buf struct) 1 (.charCodeAt \B 0))
  (set! (.-someChar struct) (.charCodeAt \C 0))
  (set! (.-someInt struct) 87)
  (js/PLANCK_TEST_SHARED_STRUCTS (.-rawBuffer struct)))
