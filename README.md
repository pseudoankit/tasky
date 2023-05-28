# Tasky
App to set events &amp; reminder, repo created to apply new concepts in practice

[Demo](https://drive.google.com/file/d/1FpIbR176fost0GjCY3byaZ6Bqba6ioTY/view?usp=sharing)

Overview :-
- Multi Module Structure 
- buildSrc to centrailize dependencies and to extract repeated portion of gradle [ref](https://github.com/pseudoankit/Tasky/tree/master/buildSrc/src/main/java)
- UI : Jetpack Compose
- Navigation : [compose destinations](https://github.com/raamcosta/compose-destinations)
- DI : Koin
- Architecture :- MVI + Clean Architecture 
- Single Activity Arch

- CI / CD 
  - generate apk on push to master
  - static code analysis with sonarcloud
  - lint check 
  
<img src="https://user-images.githubusercontent.com/54987308/223794067-e96e4191-d34e-4dd1-9d03-1b6b1816990f.png" width="500" height="600"/>

 

Planned
- [ ] unit test 
- [ ] unit test CI and jaccoco setup for coverage
- [ ] instumentation test 
- [ ] instumentation test CI 
