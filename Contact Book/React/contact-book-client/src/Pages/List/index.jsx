import React, { useState, useEffect } from "react"
import "./styles.css"
import Contacts from "./test"
import { ContactChip, Button, EditableContactChip } from "../../Components"

const StyledList = () => {

	const [contacts, setContacts] = useState({})
	useEffect(() => {
		const fetchContacts = async () => await setContacts(Contacts)
		fetchContacts()
	}, [])

	const [newContact, setNewContact] = useState(false)
	const handleAddContact = () => {
		setNewContact(true)
	}
	const finishAddingContact = (inputData) => {
		let aux = []
		contacts.forEach(contact => {
			aux.push(contact)
		})
		aux.push(inputData)
		setContacts(aux)
		setNewContact(false)
		console.log(contacts)
	}
	
	return (
		<div className="List">
			<h1>Your Contacts</h1>
			<Button
				onClick={ handleAddContact }
				text={ "Add contact" } />
			<div className="ContactList">{
				newContact &&
					<EditableContactChip
						onSave={ (inputData) => finishAddingContact(inputData) }
						onCancel={ () => setNewContact(false) } />
			}{
				// NÃO ESTÁ RENDERIZANDO QUANDO UM CONTATO NOVO É SALVO
				Contacts.map((contact) => {
					return <ContactChip contact={ contact } />
				}) 
			}</div>
		</div>
	)
}

export { StyledList }