# Tasky
App to set events &amp; reminder, repo created to apply new concepts in practice

Login | Home | App Widget | Add Reminder | Shortcuts
| :---------------: | :---------------: | :---------------: | :---------------: | :---------------: |
<img src="https://github.com/pseudoankit/Tasky/assets/54987308/7012a495-5a23-4040-98eb-79ba4fa641aa" align="center" width="410px" height ="400px"/> | <img src="https://github.com/pseudoankit/Tasky/assets/54987308/b4aec97f-3364-4a98-866e-932e6ac714a8" align="center" width="410px" height ="400px"/> | <img src="https://github.com/pseudoankit/Tasky/assets/54987308/45ced83d-254b-4771-b757-cbe2eba3015f" align="center" width="410px" height ="400px"/> | <img src="https://github.com/pseudoankit/Tasky/assets/54987308/09de8df2-4789-422d-a677-0272193c2a0a" align="center" width="410px" height ="400px"/> | <img src="https://github.com/pseudoankit/Tasky/assets/54987308/513e8ea0-9101-43f1-95ae-bc40f58febcd" align="center" width="410px" height ="400px"/>


[Demo](https://drive.google.com/file/d/1FpIbR176fost0GjCY3byaZ6Bqba6ioTY/view?usp=sharing)

Overview :-
- Architecture :- MVI + Clean Architecture
- Single Activity Arch
- Multi Module Setup 
- buildSrc to centrailize dependencies and to extract repeated portion of gradle [ref](https://github.com/pseudoankit/Tasky/tree/master/buildSrc/src/main/java)
- UI : Jetpack Compose
- Navigation : [compose destinations](https://github.com/raamcosta/compose-destinations)
- DI : Koin
- CI / CD 
  - generate apk on push to master
  - static code analysis with sonarcloud
  - lint check 
  
<img src="https://user-images.githubusercontent.com/54987308/223794067-e96e4191-d34e-4dd1-9d03-1b6b1816990f.png" width="500" height="600"/>
