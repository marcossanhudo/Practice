import "./styles.css"

const Button = ({...props}) => {
	return (
		<button className="styledButton" onClick={ props.onClick }>{ props.text }</button>
	)
}

export { Button }