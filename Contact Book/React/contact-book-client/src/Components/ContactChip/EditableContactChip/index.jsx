import React, { useState } from "react"
import "../styles.css"
import { Button, Input } from "../../"

const EditableContactChip = ({...props}) => {
	const [inputData, setInputData] = useState({})

	return (
		<div className="ContactChip">
			New contact
			<Input id="name" label="Name" onChange={ (e) => setInputData({...inputData, name: e.target.value}) } />
			<Input id="phonenum" label="Phone number" onChange={ (e) => setInputData({...inputData, phone: {number: e.target.value, tag: "" }}) } />
			<Input id="emailadd" label="Email address" onChange={ (e) => setInputData({...inputData, email: {address: e.target.value, tag: "" }}) } />
			<Button onClick={ () => props.onSave(inputData) } text={ "Save" } />
			<Button onClick={ () => props.onCancel(inputData) } text={ "Cancel" } />
		</div>
	)
}

export { EditableContactChip }