package com.firas.LoginAndRegistration.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firas.LoginAndRegistration.models.Translator;
import com.firas.LoginAndRegistration.repositories.TranslatorRepository;

@Service
public class TranslatorService {
	
	
		// === CRUD ===
		
		@Autowired
		private TranslatorRepository TranslatorRepo;
		
		// READ ALL
		public List<Translator> allTranslators(){
			return TranslatorRepo.findAll();
		}

	    public List<Translator> findAllTranslatorsWithAddress() {
	        return TranslatorRepo.findAllTranslatorsWithAddress();
	    }
	    
		
		// CREATE
		public Translator createTranslator(Translator t) {
			return TranslatorRepo.save(t);
		}
		
		// READ ONE
		public Translator findTranslator(Long id) {
			
			Optional<Translator> maybeTranslator = TranslatorRepo.findById(id);
			if(maybeTranslator.isPresent()) {
				return maybeTranslator.get();
			}else {
				return null;
			}
		}
		
		// UPDATE 
		public Translator updateTranslator(Translator t) {
			return TranslatorRepo.save(t);
		}
		
		// DELETE
		public void deleteTranslator(Long id) {
			TranslatorRepo.deleteById(id);
		}
		public Translator findTranslatorWithAddress(Long id) {
		    // Fetch the Translator entity along with its associated Address
		    return TranslatorRepo.findTranslatorWithAddressById(id);
		}
		
	    public Translator getTranslatorById(Long id) {
	        // Implement logic to retrieve a Translator by its ID from the repository
	        Optional<Translator> optionalTranslator = TranslatorRepo.findById(id);
	        
	        return optionalTranslator.orElse(null);
	    }
	}


