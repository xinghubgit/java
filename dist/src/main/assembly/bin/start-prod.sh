#!/bin/bash

base_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${base_dir}/start.sh -e prod -p 30060 -c ${base_dir}/../env_conf/
