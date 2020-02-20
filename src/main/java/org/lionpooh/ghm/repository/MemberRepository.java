package org.lionpooh.ghm.repository;

import org.lionpooh.ghm.controller.vo.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {

}
