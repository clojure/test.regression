#!/bin/bash

# define the new version you want to use
new_version=1.12.0-master-SNAPSHOT

# use sed to replace the version inline
sed -i.bak "s/\(org.clojure\/clojure\ \"[0-9\.]*\"\)/org.clojure\/clojure \"$new_version\"/g" project.clj