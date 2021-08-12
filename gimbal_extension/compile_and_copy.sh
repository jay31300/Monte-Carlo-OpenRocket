gradle jar
if [ $? -eq 0 ]; then
    yes | cp -rf build/libs/* ~/.openrocket/Plugins/
fi
