package com.sih.controller.general;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sih.entities.general.UserGroupeBlock;
import com.sih.entities.general.Disposer;
import com.sih.entities.general.DisposerBlock;
import com.sih.entities.general.Exercice;
import com.sih.entities.general.ExerciceBlock;
import com.sih.entities.general.Groupe;
import com.sih.entities.general.GroupeBlock;
import com.sih.entities.general.UserGroup;
import com.sih.entities.general.Utilisateur;
import com.sih.entities.general.UtilisateurBlock;
import com.sih.services.general.DisposerService;
import com.sih.services.general.ExerciceService;
import com.sih.services.general.GroupeService;
import com.sih.services.general.UserGroupeService;
import com.sih.services.general.UtilisateurService;

@RestController
@RequestMapping(path = "sih/gen/")
public class GeneralControler {
	private final DisposerService dis;
	private final GroupeService gpe;
	private final UserGroupeService uge;
	private final UtilisateurService use;
	private final ExerciceService exo;
	
	public GeneralControler(DisposerService dis, GroupeService gpe, UserGroupeService uge, UtilisateurService use,
			ExerciceService exo) {
		super();
		this.dis = dis;
		this.gpe = gpe;
		this.uge = uge;
		this.use = use;
		this.exo = exo;
	}
	
	///////////////Actions sur utilisateur
	@GetMapping("us/list")
	public List<Utilisateur> listUser(){
		return use.list();
	}
	
	@GetMapping("us/byId/{id}")
	public Utilisateur findUser(@PathVariable(name = "id") Long id) {
		return use.select(id);
	}
	
	@PostMapping("us/list")
	Utilisateur addingUser(@RequestBody UtilisateurBlock us){
		return use.insert(us.getUser(), us.getAuteur());
	}
	
	@PutMapping("us/list")
	public Utilisateur editingUser(@RequestBody UtilisateurBlock us) {
		return use.edit(us.getUser(), us.getAuteur());
	}
	
	@DeleteMapping("us/list")
	public void deletingUser(UtilisateurBlock us) {
		use.delete(us.getUser().getIdUser(), us.getAuteur());
	}
	
	
	//////////////Interaction sur le groupes
	@GetMapping("gpe/list")
	public List<Groupe> listGroupe(){
		return gpe.list();
	}
	
	@GetMapping("gpe/byId/{id}")
	public Groupe findGroupe(@PathVariable(name = "id") Long id) {
		return gpe.select(id);
	}
	
	@PostMapping("gpe/list")
	Groupe addingGroupe(@RequestBody GroupeBlock bloc){
		return gpe.insert(bloc.getGpe(), bloc.getAuteur());
	}
	
	@PutMapping("gpe/list")
	public Groupe editingGroupe(@RequestBody GroupeBlock bloc) {
		return gpe.edit(bloc.getGpe(), bloc.getAuteur());
	}
	
	@DeleteMapping("gpe/list")
	public void deletingGroupe(GroupeBlock bloc) {
		gpe.delete(bloc.getGpe().getIdGpe(), bloc.getAuteur());
	}
	
	
	//////////////Interaction sur le association utilisateur-groupe
	@GetMapping("ug/list")
	public List<UserGroup> listUserGroupe(){
		return uge.list();
	}
	
	@GetMapping("ug/byId/{id}")
	public UserGroup findUserGroupe(@PathVariable(name = "id") Long id) {
		return uge.select(id);
	}
	
	@PostMapping("ug/list")
	UserGroup addingUserGroupe(@RequestBody UserGroupeBlock bloc){
		return uge.insert(bloc.getUseGroup(), bloc.getAuteur());
	}
	
	@PutMapping("ug/list")
	public UserGroup editingUserGroupe(@RequestBody UserGroupeBlock bloc) {
		return uge.edit(bloc.getUseGroup(), bloc.getAuteur());
	}
	
	@DeleteMapping("ug/list")
	public void deletingUserGroupe(UserGroupeBlock bloc) {
		uge.delete(bloc.getUseGroup().getIdUsGpe(), bloc.getAuteur());
	}
	
	
	//////////////Interaction sur le association groupe-Droit-Objet
	@GetMapping("dis/list")
	public List<Disposer> listDisposer(){
		return dis.list();
	}
	
	@GetMapping("dis/byId/{id}")
	public Disposer findDisposer(@PathVariable(name = "id") Long id) {
		return dis.select(id);
	}
	
	@PostMapping("dis/list")
	Disposer addingDisposer(@RequestBody DisposerBlock bloc){
		return dis.insert(bloc.getDisposer(), bloc.getAuteur());
	}
	
	@PutMapping("dis/list")
	public Disposer editingDisposer(@RequestBody DisposerBlock bloc) {
		return dis.edit(bloc.getDisposer(), bloc.getAuteur());
	}
	
	@DeleteMapping("dis/list")
	public void deletingDisposer(DisposerBlock bloc) {
		dis.delete(bloc.getDisposer().getIdDis(), bloc.getAuteur());
	}
	
	
	//////////////Interaction sur exercice
	@GetMapping("exo/list")
	public List<Exercice> listExercice(){
		return exo.list();
	}
	
	@GetMapping("exo/byId/{id}")
	public Exercice findEcercice(@PathVariable(name = "id") String id) {
		return exo.select(id);
	}
	
	@PostMapping("exo/list")
	Exercice addingExercice(@RequestBody ExerciceBlock bloc){
		return exo.insert(bloc.getExo(), bloc.getAuteur());
	}
	
	@PutMapping("exo/list")
	public Exercice editingExercice(@RequestBody ExerciceBlock bloc) {
		return exo.edit(bloc.getExo(), bloc.getAuteur());
	}
	
	@DeleteMapping("exo/list")
	public void deletingExercice(ExerciceBlock bloc) {
		exo.delete(bloc.getExo().getCodExo(), bloc.getAuteur());
	}
}
