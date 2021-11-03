import UAParser from 'ua-parser-js'

const ua = new UAParser()
const result = ua.getResult()

export default result
