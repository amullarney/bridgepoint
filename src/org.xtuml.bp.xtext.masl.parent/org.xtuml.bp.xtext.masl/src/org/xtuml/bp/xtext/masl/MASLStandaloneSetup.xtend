/*
 * generated by Xtext 2.9.2
 */
package org.xtuml.bp.xtext.masl

import com.google.inject.Injector
import org.xtuml.bp.xtext.masl.lib.MASLLibraryProvider

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class MASLStandaloneSetup extends MASLStandaloneSetupGenerated {

	def static void doSetup() {
		new MASLStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	override register(Injector injector) {
		super.register(injector)
		MASLLibraryProvider.register()
	}
	
}