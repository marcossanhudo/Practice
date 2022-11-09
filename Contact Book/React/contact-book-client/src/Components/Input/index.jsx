import "./styles.css"

const Input = ({...props}) => {
	return (
		<div>{
			props.label
			? <label for={ props.id }>{ props.label }</label>
			: null
		}
		<input className="styledInput"
		onChange={ (e) => props.onChange(e) }
		type={ props.type }
		id={ props.id }
		name={ props.name }
		value={ props.value } /></div>
	)
}

export { Input }