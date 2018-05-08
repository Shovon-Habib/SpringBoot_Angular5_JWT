//package com.example.demo.dummydata;
//
//import com.example.demo.model.Role;
//import com.example.demo.repository.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DummyDataLiveServer implements ApplicationListener<ContextRefreshedEvent> {
//
//    private final RoleRepository roleRepository;
//
//    @Autowired
//    public DummyDataLiveServer(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//        try {
//            Role role1 = new Role();
//            role1.setRole("USER");
//            roleRepository.save(role1);
//
//            Role role2 = new Role();
//            role2.setRole("ADMIN");
//            roleRepository.save(role2);
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//
//    }
//}
//
