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
		contacts.push(inputData)
		setNewContact(false)
	}
	const handleEdit = (currentData) => {
	}
	
	return (
		<div className="List">
			<h1>Your Contacts</h1>
			<Button
				onClick={ handleAddContact }
				text={ "Add contact" } />
			<div className="ContactList">
				{
					newContact &&
						<EditableContactChip
							onSave={ (inputData) => finishAddingContact(inputData) }
							onCancel={ () => setNewContact(false) } />
				}
				{
					Contacts.map((contact) => {
						return <EditableContactChip
								contact={ contact }
								onSave={ (inputData) => finishAddingContact(inputData) }
								onCancel={ () => setNewContact(false) } />
					}) 
				}
			</div>
		</div>
	)
}

export { StyledList }