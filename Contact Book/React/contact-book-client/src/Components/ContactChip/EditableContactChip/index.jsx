import React, { useState, useEffect } from "react"
import "../styles.css"
import { Button, Input } from "../../"

const EditableContactChip = ({...props}) => {
	const [inputData, setInputData] = useState(props.contact ? props.contact : {
		name: "",
		phone: {
			number: "",
			tag: ""
		}
	})
	const [editing, setEditing] = useState(false)

	return (
		<div className="ContactChip">
			{ props.contact && !editing
				? <div>
					{
						props.contact.name &&
							<div className="Name">{props.contact.name}</div>
					}
					{
						props.contact.phone &&
							<div className="Phone">
								<div className="Number"><a href={"tel:" + props.contact.phone.number}>{props.contact.phone.number}</a></div>
								<div className="Tag">{props.contact.phone.tag}</div>
							</div>
					}
					<Button
						text={ "Edit" }
						onClick={ () => setEditing(true) } />
				</div> : <div>
					New contact
					<Input id="name" label="Name" onChange={ (e) => setInputData({...inputData, name: e.target.value}) } />
					<Input id="phonenum" label="Phone number" onChange={ (e) => setInputData({...inputData, phone: {number: e.target.value, tag: "" }}) } />
					<Input id="emailadd" label="Email address" onChange={ (e) => setInputData({...inputData, email: {address: e.target.value, tag: "" }}) } />
					<Button onClick={ () => { setEditing(false); props.onSave(inputData) }  } text={ "Save" } />
					<Button onClick={ () => { setEditing(false); props.onCancel(inputData) } } text={ "Cancel" } />
				</div>
			}
		</div>
	)
}

export { EditableContactChip }