# Tasky
App to set events &amp; reminder, repo created to apply new concepts in practice

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

Planned
- [ ] unit test 
- [ ] unit test CI and jaccoco setup for coverage
- [ ] instumentation test 
- [ ] instumentation test CI 
