# Super Toast Library  

###### Usual Toast but with super powers!!! :muscle:

### A Fully Customised and Customisable Toast.

![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Super%20Toast-green.svg?style=flat )]( https://android-arsenal.com/details/1/7328 )

| Type  | Output |
| ------------- | ------------- |
| Success  |![Alt text](https://github.com/akhilbv1/CustomToastLibrary/blob/master/app/sampledata/Success.png?raw=true "Success")|
| Warning  |![Alt text](https://github.com/akhilbv1/CustomToastLibrary/blob/master/app/sampledata/Warning.png?raw=true "Warning")|
| Error  |![Alt text](https://github.com/akhilbv1/CustomToastLibrary/blob/master/app/sampledata/Failure.png?raw=true "Failure")|
| Information  |![Alt text](https://github.com/akhilbv1/CustomToastLibrary/blob/master/app/sampledata/Information.png?raw=true "Information")|
| Default  |![Alt text](https://github.com/akhilbv1/CustomToastLibrary/blob/master/app/sampledata/Default.png?raw=true "Default")|

### Gradle DepenDencies 
```
implementation 'com.github.akhilbv1:CustomToastLibrary:Tag'
```
### Add Jitpack to repositories in Project level Build.Gradle
```
repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
```
### How To Call
```java
 CustomToast.makeText(this, Toast.LENGTH_SHORT,CustomToast.DEFAULT, "Toast is working",false).show();
```
| Method  | Paramter | Description |
| ------------- | ------------- | ------------- |
| makeDefaultToast()  | Context context,String message|Default Toast|
| makeSuccessToast()  |Context context,String message,int shouldShowIcon| Success Toast with message and icon visibility||
| makeErrorToast()  | Context context,String message, int shouldShowIcon|Error Toast with message and icon visibility|
| makeWarningToast()  |Context context, String message, int shouldShowIcon|Warning Toast with message and icon visibility|
| makeInfoToast()  |@NonNull Context context,  String message, int shouldShowIcon|Information Toast with message and icon visibility|

### Future Release Points
 - Provide Options for Custom Layouts
 - Add Animations
 
 ### All commits are welcomed!!

