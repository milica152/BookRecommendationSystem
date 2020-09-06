import React, {useState} from 'react';
import booksService from "../services/booksService";

const SearchBar = (props) => {
    const [recommendationDTO, setRecommendationDTO] = useState({age : 0, gender: "", sphereOfInterest: [], booksRead: [], maxPrice: 0, genre: ""});
    const [searchParameter, setSearchParameter] = useState("");

    const onSearch = () => props.onSearch.bind(searchParameter);
    const changeSearchParam = (e) => setSearchParameter(e.target.value);
    const changeRecommendation = (e) => {
        const targetName = e.target.name;
        const targetValue = e.target.value;

        setRecommendationDTO(prevState => {
            return { ...prevState,  [targetName]: targetValue }
        });
    };

    const getRecommendation = async () => {
        const response = await booksService.getRecommendation(recommendationDTO);
        props.onGetRecommendation(response);
        console.log(response);
    };

    const changeRecommendationSpheres = async (e) => {
        let list = recommendationDTO.sphereOfInterest;
        e.target.checked
            ? list.push(e.target.name)
            : list = list.filter((item) => item !== e.target.name);

        await setRecommendationDTO({...recommendationDTO, sphereOfInterest: list});
    };

    return <div className="grey-box-wrap reports" align="left">
        <div className="search-page" style={{borderWidth: '1px', borderColor: 'dimgrey'}}>
            <ul className="form">
                <li>
                    <label>Age:</label>
                    <input type="number" className="in-text" name = "age"  min={0} value = {recommendationDTO.age}  onChange={changeRecommendation} />
                </li>
                <li>
                    <label>Gender:</label>
                    <select onChange={changeRecommendation} name = "gender">
                        <option disabled={true} selected={true}>Select gender</option>
                        <option value="MALE"> Male</option>
                        <option value="FEMALE">Female</option>
                    </select>
                </li>
            </ul>
            <ul className="form">
                <li>
                    <label>Genre:</label>
                    <select  onChange={changeRecommendation} name = "genre">
                        <option disabled={true} selected={true}>Select genre</option>
                        <option value="ROMANCE">ROMANCE</option>
                        <option value="CHILDREN">CHILDREN</option>
                        <option value="EDUCATION">EDUCATION</option>
                        <option value="CRIME">CRIME</option>
                        <option value="DRAMA">DRAMA</option>
                        <option value="SCI_FI">SCIENCE FICTION</option>
                        <option value="BIOGRAPHY">BIOGRAPHY</option>
                        <option value="COMEDY">COMEDY</option>
                        <option value="COOKING">COOKING</option>
                        <option value="HISTORY">HISTORY</option>
                        <option value="MUSIC">MUSIC</option>
                        <option value="SPORT">SPORT</option>
                        <option value="CLASSIC">CLASSIC</option>
                    </select>
                </li>
                <li>
                    <label>Maximum price:</label>
                    <input type="number" className="in-text" min={0} value = {recommendationDTO.maxPrice} name = "maxPrice" onChange={changeRecommendation}/>
                </li>
            </ul>
            <div>
                <div>
                <ul className="form">
                    <li>
                        <label>Spheres of interests</label>
                        <label htmlFor="CELEBRITY"><input id="CELEBRITY" type="checkbox"  className="item" name = "CELEBRITY" onChange={changeRecommendationSpheres}/> CELEBRITY</label>
                        <label htmlFor="ADVENTURE"><input id="ADVENTURE" type="checkbox" name = "ADVENTURE" onChange={changeRecommendationSpheres}/> ADVENTURE</label>
                        <label  htmlFor="TRUE_EVENTS"><input id="TRUE_EVENTS"  type="checkbox" name = "TRUE_EVENTS" onChange={changeRecommendationSpheres}/> TRUE_EVENTS</label>
                        <label  htmlFor="FICTION"><input type="checkbox" name = "FICTION" id="FICTION"  onChange={changeRecommendationSpheres}/> FICTION</label>
                        <label  htmlFor="HISTORY_OF_LITERATURE"><input type="checkbox" name = "HISTORY_OF_LITERATURE" id="HISTORY_OF_LITERATURE"  onChange={changeRecommendationSpheres}/> HISTORY_OF_LITERATURE</label>
                        <label  htmlFor="FUN"><input type="checkbox" name = "FUN" id="FUN"  onChange={changeRecommendationSpheres}/> FUN</label>
                        <label  htmlFor="FOOD"><input type="checkbox" id="FOOD" name = "FOOD" onChange={changeRecommendationSpheres}/> FOOD</label>
                        <label  htmlFor="WORLD_LITERATURE"><input type="checkbox" id="WORLD_LITERATURE" name = "WORLD_LITERATURE" onChange={changeRecommendationSpheres}/> WORLD_LITERATURE</label>
                        <label  htmlFor="LEARNING"><input type="checkbox" id="LEARNING" name = "LEARNING" onChange={changeRecommendationSpheres}/> LEARNING</label>

                    </li>
                </ul>
                </div>
                <ul className="form">
                    <li>
                        <label  htmlFor="MUSIC"> <input type="checkbox" id="MUSIC" name = "MUSIC" onChange={changeRecommendationSpheres}/> MUSIC</label>
                        <label  htmlFor="SPORT"><input type="checkbox" id="SPORT" name = "SPORT" onChange={changeRecommendationSpheres}/> SPORT</label>
                        <label  htmlFor="SCIENCE"> <input type="checkbox" id="SCIENCE" name = "SCIENCE" onChange={changeRecommendationSpheres}/> SCIENCE</label>
                        <label  htmlFor="INTERPERSONAL_RELATIONSHIP"><input type="checkbox" id="INTERPERSONAL_RELATIONSHIP" name = "INTERPERSONAL_RELATIONSHIP" onChange={changeRecommendationSpheres}/> INTERPERSONAL_RELATIONSHIP</label>
                        <label  htmlFor="HISTORY"><input type="checkbox" id="HISTORY" name = "HISTORY" onChange={changeRecommendationSpheres}/> HISTORY</label>
                        <label  htmlFor="TECHNOLOGY"><input type="checkbox" id="TECHNOLOGY" name = "TECHNOLOGY" onChange={changeRecommendationSpheres}/> TECHNOLOGY</label>
                        <label  htmlFor="CREATIVITY"><input type="checkbox" id="CREATIVITY" name = "CREATIVITY" onChange={changeRecommendationSpheres}/> CREATIVITY</label>
                        <label  htmlFor="SHOW_BUSINESS"><input type="checkbox" id="SHOW_BUSINESS" name = "SHOW_BUSINESS" onChange={changeRecommendationSpheres}/> SHOW_BUSINESS</label>
                    </li>
                </ul>
            </div>
            <div className="buttons">
                <div className="inner">
                    <a href="#" className="btn green" onClick={getRecommendation}>Get recommendation</a>
                </div>
            </div>
        </div>

        <div className="search-page" style={{borderWidth: '1px', borderColor: 'dimgrey', float : 'right'}}>
            <input type="search" name="search-clients" className="in-search" onChange={changeSearchParam} value={searchParameter}/>
            <span style={{paddingLeft: '30px'}} >
                <button className="btn green" onClick={onSearch}> Search </button>
            </span>
        </div>

    </div>;
};

export default SearchBar;
