# CS5004Lab03
Repository for CS5004 Lab03 assignment submission

Name: Xuedinan(Dinan) Gao\
Semester: 2024 Spring

### My submission includes following directory/files

- Blocks, Resource, Factories classes
- Main class\
  ![image](https://github.com/Xuedinan/CS5004Lab03/assets/144306521/7e1cc168-bd77-4c59-aa53-8c325fafb6b7)

- FactoryTest, Resource Test classes\
  ![image](https://github.com/Xuedinan/CS5004Lab03/assets/144306521/0d23f1a0-dae4-4f45-a8cc-6fc59030506c)

### In addition to the requested method, I have extensions below

- New resource type, Concrete
  - New concrete block
  - New concrete block factory
    
- Using ArrayList to store blocks
- Set capacity for each block inventory
- New completely different driver
  - Test breakBlock inside the driver

- Create some JUnit tests
- Add more exception handling for methods that take argument

### My test case is in the NewDriver Class
My driver testing will follow the below work-flow
1. create three types of resources
2. create three block factory
3. create a house factory
4. add weight, subtract weight from all resources 
5. product blocks for each resource
6. break blocks
7. receive returned resource
8. transfer returned resources to block factories
9. try to build the house
10. if blocks are not enough, add more blocks then produce
11. break house check what be returned
