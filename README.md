# TYODROID BOILERPLATE

A boilerplate android App that uses tyodroid framework for easy android App development.

# Things to do

## Clone the code
```
git clone git@github.com:e-tang/tyodroid-boilerplate.git
cd tyodroid-boilerplate
git submodule init
git submodule update --remote --recursive
cat .gitmodules | grep "path =" | cut -f 2 -d "=" | while read line; do cd $line; echo "In folder $line:";  git checkout master; echo; cd ..; done
```

Note:
Please replace tyodroid-boilerplate with whatever name you prefer for your project.

## Change the package name

### Option 1
* Rename the package name to [xxx] with Android Studio's refactoring tool
* Make sure the package name is updated int Manifest.xml
* Make sure the package name is updated in build.gradle in the app folder
* "Sync Now", otherwise, "File"->"Sync Project with Gradle files"
* "Edit"->"Find"->"Replace in Path", "sample.R" >> "[xxx].R"

### Option 2
* "Project Structure"->"app"->"Flavor"->"defaultConfig"->"Application id": xxxx
* Rename the package name to [xxx] with Android Studio's refactoring tool
* Make sure the package name is updated int Manifest.xml