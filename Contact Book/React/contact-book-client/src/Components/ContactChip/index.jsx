import "./styles.css"
import { Button } from "../Button"
import { EditableContactChip } from "./EditableContactChip"

const ContactChip = ({...props}) => {
	return (
		<div className="ContactChip">
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
			<Button text={ "Edit" } onClick={ () => props.onEdit() } />
		</div>
	)
}

export { ContactChip, EditableContactChip }