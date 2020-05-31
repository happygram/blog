package project.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.blog.domain.Authorities;
import project.blog.dto.UsersDto;
import project.blog.repository.AuthoritiesRepository;
import project.blog.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<UsersDto> getUsers(){
		return usersRepository.findAll().stream().map(users -> modelMapper.map(users, UsersDto.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public UsersDto newUsers(UsersDto usersDto) {
		// 사용자 저장
		// 암호화
		usersDto.setPassword(new BCryptPasswordEncoder().encode(usersDto.getPassword()));
		UsersDto resultDto = modelMapper.map(usersRepository.save(usersDto.toEntity()), UsersDto.class);
		// 권한 저장
		authoritiesRepository.save(Authorities.builder()
											.username(usersDto.getUsername())
											.authority("ROLE_ADMIN")
											.build());
		return resultDto;
	}
}